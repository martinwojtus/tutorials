import { Droppable, Draggable } from 'react-beautiful-dnd';
import styled from 'styled-components';
import { Button, Card } from 'antd';
import { TaskboardItem, TaskboardItemStatus } from './TaskboardTypes';
import TaskboardItemCard, { TaskboardItemCardProps } from './TaskboardItemCard';
import { colors } from '../shared/SharedUtils';
import React from 'react';

const TaskboardColRoot = styled(Card)`
  user-select: none;
  flex: 1;
  margin: 0.5rem;
  display: flex;
  flex-direction: column;
  // To force each flex item to have equal width
  // even if they have long texts with no spaces etc.
  min-width: 0;
  > .ant-card-body {
    overflow: hidden;
    height: 100%;
    padding: 0;
  }
`;

interface DroppableRootProps {
  isDraggingOver: boolean;
}

const DroppableRoot = styled.div<DroppableRootProps>`
  height: 100%;
  overflow-y: auto;
  background-color: ${({ isDraggingOver }) =>
    isDraggingOver ? colors.primary[2] : colors.primary[1]};
`;

export type TaskboardColProps = Pick<
  TaskboardItemCardProps,
  'onEdit' | 'onDelete'
> & {
  items: TaskboardItem[];
  status: TaskboardItemStatus;
  onClickAdd?: VoidFunction;
};

function TaskboardCol({
  items,
  status,
  onClickAdd,
  onEdit,
  onDelete,
}: TaskboardColProps) {
  return (
    <TaskboardColRoot
      title={`${status} (${items.length})`}
      extra={
        onClickAdd && (
          <Button type="primary" onClick={onClickAdd}>
            Add
          </Button>
        )
      }
    >
      <Droppable droppableId={status}>
        {(provided, snapshot) => (
          <DroppableRoot
            ref={provided.innerRef}
            {...provided.droppableProps}
            isDraggingOver={snapshot.isDraggingOver}
          >
            {items.map((item, index) => {
              return (
                <Draggable key={item.id} draggableId={item.id} index={index}>
                  {(provided, snapshot) => (
                    <div
                      key={item.id}
                      ref={provided.innerRef}
                      {...provided.draggableProps}
                      {...provided.dragHandleProps}
                    >
                      <TaskboardItemCard
                        item={item}
                        status={status}
                        isDragging={snapshot.isDragging}
                        onEdit={onEdit}
                        onDelete={onDelete}
                      />
                    </div>
                  )}
                </Draggable>
              );
            })}
            {provided.placeholder}
          </DroppableRoot>
        )}
      </Droppable>
    </TaskboardColRoot>
  );
}

export default TaskboardCol;
