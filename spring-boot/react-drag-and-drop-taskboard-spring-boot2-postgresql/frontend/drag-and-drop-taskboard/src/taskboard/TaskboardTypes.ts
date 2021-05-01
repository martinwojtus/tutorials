export interface TaskboardItem {
  id: string;
  title: string;
  description: string;
  position: number;
  status: TaskboardItemStatus;
}

export enum TaskboardItemStatus {
  TO_DO = 'To Do',
  IN_PROGRESS = 'In Progress',
  DONE = 'Done',
}


export type TaskboardData = Record<TaskboardItemStatus, TaskboardItem[]>;