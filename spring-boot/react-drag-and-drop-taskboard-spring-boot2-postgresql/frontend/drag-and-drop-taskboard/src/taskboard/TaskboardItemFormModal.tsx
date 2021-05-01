import { useEffect, useRef } from 'react';
import { Modal, Form, ModalProps, Input } from 'antd';
import { TaskboardItem } from './TaskboardTypes';
import React from 'react';

export type TaskboardItemFormValues = Pick<
  TaskboardItem,
  'title' | 'description'
>;

type TaskboardItemFormModalProps = Pick<ModalProps, 'visible'> & {
  initialValues: TaskboardItemFormValues;
  onCancel: VoidFunction;
  onOk: (values: TaskboardItemFormValues) => void;
};

function TaskboardItemFormModal({
  visible,
  initialValues,
  onCancel,
  onOk,
}: TaskboardItemFormModalProps) {
  const [form] = Form.useForm<TaskboardItemFormValues>();

  const inputRef = useRef<Input>(null);

  useEffect(() => {
    if (visible) {
      // Focus on the first input when the modal is opened
      inputRef.current?.focus();
      form.resetFields();
    }
  }, [form, visible]);

  return (
    <Modal
      title="Add Item"
      visible={visible}
      destroyOnClose
      // To make dynamically changing initialValues work with Form
      forceRender
      onCancel={onCancel}
      onOk={() => form.submit()}
    >
      <Form
        autoComplete="off"
        form={form}
        layout="vertical"
        initialValues={initialValues}
        onFinish={(values) => {
          onOk(values);
          form.resetFields();
          onCancel();
        }}
      >
        <Form.Item
          name="title"
          label="Title"
          rules={[
            { required: true, message: "'Title' is required" },
            {
              max: 100,
              message: "'Title' can not be longer than 100 characters",
            },
          ]}
        >
          <Input ref={inputRef} autoFocus />
        </Form.Item>
        <Form.Item
          name="description"
          label="Description"
          rules={[
            { required: true, message: "'Description' is required" },
            {
              max: 400,
              message: "'Description' can not be longer than 400 characters",
            },
          ]}
        >
          <Input.TextArea rows={4} />
        </Form.Item>
      </Form>
    </Modal>
  );
}

export default TaskboardItemFormModal;
