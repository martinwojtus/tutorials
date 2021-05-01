import axios from 'axios';
import { TaskboardItem } from './TaskboardTypes';

const BASE_URL = 'http://localhost:8080';

export const createTask = (task: TaskboardItem) => axios.post<TaskboardItem>(`${BASE_URL}/tasks`, task);

export const getAllTasks = () => axios.get<TaskboardItem[]>(`${BASE_URL}/tasks`);

export const changeTaskPosition = (task: TaskboardItem) => axios.post(`${BASE_URL}/tasks/position`, task);

export const deleteTask = (id: string) => axios.delete(`${BASE_URL}/tasks/${id}`);

export const updateTask = (task: TaskboardItem) => axios.put<TaskboardItem>(`${BASE_URL}/tasks/${task.id}`, task);
