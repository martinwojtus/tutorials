import { DragDropContext, DragDropContextProps } from 'react-beautiful-dnd';
import React, { useEffect, useMemo, useState } from 'react';
import produce from 'immer';
import styled from 'styled-components';
import { TaskboardData, TaskboardItem, TaskboardItemStatus } from './TaskboardTypes';
import TaskboardItemFormModal, { TaskboardItemFormValues, } from './TaskboardItemFormModal';
import TaskboardCol, { TaskboardColProps } from './TaskboardCol';
import { useSyncedState } from '../shared/SharedHooks';
import { changeTaskPosition, createTask, deleteTask, getAllTasks, updateTask } from './TaskService';

const TaskboardRoot = styled.div`
  min-height: 0;
  height: 100%;
  min-width: 800px;
  max-width: 1400px;
  margin: auto;
`;

const TaskboardContent = styled.div`
  height: 100%;
  padding: 0.5rem;
  display: flex;
  justify-content: space-around;
`;

const defaultItems = {
  [TaskboardItemStatus.TO_DO]: [],
  [TaskboardItemStatus.IN_PROGRESS]: [],
  [TaskboardItemStatus.DONE]: [],
};

function Taskboard() {
  const [ itemsByStatus, setItemsByStatus ] = useSyncedState<TaskboardData>(
    'itemsByStatus',
    defaultItems
  );

  useEffect(() => {
    getAllTasks().then(response => {
      setItemsByStatus({
        [TaskboardItemStatus.TO_DO]: response.data.filter(task => task.status == TaskboardItemStatus.TO_DO),
        [TaskboardItemStatus.IN_PROGRESS]: response.data.filter(task => task.status == TaskboardItemStatus.IN_PROGRESS),
        [TaskboardItemStatus.DONE]: response.data.filter(task => task.status == TaskboardItemStatus.DONE),
      });
    });
  }, []);

  const handleDragEnd: DragDropContextProps['onDragEnd'] = ({
                                                              source,
                                                              destination,
                                                            }) => {
    if (destination) {
      const task = itemsByStatus[source.droppableId as TaskboardItemStatus][source.index];

      changeTaskPosition({
        id: task.id,
        status: destination.droppableId as TaskboardItemStatus,
        position: destination.index,
        title: task.title,
        description: task.description
      }).then(result => {

        setItemsByStatus((current) =>
          produce(current, (draft) => {
            // dropped outside the list
            if (!destination) {
              return;
            }
            const [ removed ] = draft[
              source.droppableId as TaskboardItemStatus
              ].splice(source.index, 1);
            draft[destination.droppableId as TaskboardItemStatus].splice(
              destination.index,
              0,
              removed
            );
          })
        );

      }).catch(error => console.error(error));
    }
  };

  const [ isModalVisible, setIsModalVisible ] = useState(false);

  const [ itemToEdit, setItemToEdit ] = useState<TaskboardItem | null>(null);

  const openTaskItemModal = (itemToEdit: TaskboardItem | null) => {
    setItemToEdit(itemToEdit);
    setIsModalVisible(true);
  };

  const closeTaskItemModal = () => {
    setItemToEdit(null);
    setIsModalVisible(false);
  };

  const handleDelete: TaskboardColProps['onDelete'] = ({
                                                         status,
                                                         itemToDelete,
                                                       }) => {

    deleteTask(itemToDelete.id).then(result => {
      setItemsByStatus((current) =>
        produce(current, (draft) => {
          draft[status] = draft[status].filter(
            (item) => item.id !== itemToDelete.id
          );
        })
      );
    }).catch(error => console.error(error));
  };

  const initialValues = useMemo<TaskboardItemFormValues>(
    () => ({
      title: itemToEdit?.title ?? '',
      description: itemToEdit?.description ?? '',
    }),
    [ itemToEdit ]
  );

  return (
    <>
      <DragDropContext onDragEnd={handleDragEnd}>
        <TaskboardRoot>
          <TaskboardContent>
            {Object.values(TaskboardItemStatus).map((status) => (
              <TaskboardCol
                key={status}
                status={status}
                items={itemsByStatus[status]}
                onClickAdd={
                  status === TaskboardItemStatus.TO_DO
                    ? () => openTaskItemModal(null)
                    : undefined
                }
                onEdit={openTaskItemModal}
                onDelete={handleDelete}
              />
            ))}
          </TaskboardContent>
        </TaskboardRoot>
      </DragDropContext>
      <TaskboardItemFormModal
        visible={isModalVisible}
        onCancel={closeTaskItemModal}
        onOk={(values) => {

          if (itemToEdit) {
            updateTask({
              ...values,
              status: itemToEdit.status,
              position: itemToEdit.position,
              id: itemToEdit.id
            }).then(result => {

              setItemsByStatus((current) =>
                produce(current, (draft) => {
                  if (itemToEdit) {
                    // Editing existing item
                    const draftItem = Object.values(draft)
                      .flatMap((items) => items)
                      .find((item) => item.id === itemToEdit.id);
                    if (draftItem) {
                      draftItem.title = values.title;
                      draftItem.description = values.description;
                    }
                  }
                })
              );

            }).catch(error => console.error(error));

          } else {
            createTask({
              ...values,
              status: TaskboardItemStatus.TO_DO,
              position: 1,
              id: ''
            }).then(response => {

              setItemsByStatus((current) =>
                produce(current, (draft) => {
                  // Adding new item as "to do"
                  draft[TaskboardItemStatus.TO_DO].push({
                    ...values,
                    id: response.data.id,
                    status: TaskboardItemStatus.TO_DO,
                    position: response.data.position
                  });
                }));

            }).catch(error => console.error(error));
          }

        }}
        initialValues={initialValues}
      />
    </>
  );
}

export default Taskboard;
