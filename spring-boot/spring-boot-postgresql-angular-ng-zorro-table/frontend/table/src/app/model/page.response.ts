export interface PageResponse<T> {
  rows: T[];
  totalElements: number;
  totalPages: number;
}
