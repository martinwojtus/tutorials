import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Employee } from '../model/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {

  constructor(private http: HttpClient) {
  }

  list(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${environment.baseUrl}/employees`);
  }

  deleteAll(ids: string[]): Observable<void> {
    return this.http.post<void>(`${environment.baseUrl}/employees/delete`, ids);
  }

  save(employee: Employee): Observable<void> {
    return this.http.post<void>(`${environment.baseUrl}/employees`, employee);
  }

  update(employee: Employee): Observable<void> {
    return this.http.put<void>(`${environment.baseUrl}/employees/${employee.id}`, employee);
  }
}
