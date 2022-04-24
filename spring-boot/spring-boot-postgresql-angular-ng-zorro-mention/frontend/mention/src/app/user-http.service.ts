import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

const baseUrl = `${environment.baseUrl}`;

@Injectable({
  providedIn: 'root'
})
export class UserHttpService {

  constructor(private http: HttpClient) {
  }

  list(filter: string): Observable<string[]> {
    let queryParams = new HttpParams();
    queryParams.set('filter', filter);
    return this.http.get<string[]>(`${baseUrl}/api/users`, {params: queryParams});
  }

  save(list: string[]): Observable<any> {
    return this.http.post(`${baseUrl}/api/users/top`, {usernames: list});
  }

  getTopUsers(): Observable<string[]> {
    return this.http.get<string[]>(`${baseUrl}/api/users/top`);
  }
}
