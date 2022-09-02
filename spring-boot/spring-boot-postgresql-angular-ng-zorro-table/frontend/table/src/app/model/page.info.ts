import { Sorting } from './sorting';

export interface PageInfo {
  pageNumber: number;
  pageSize: number;
  sort: Sorting[] | null;
}
