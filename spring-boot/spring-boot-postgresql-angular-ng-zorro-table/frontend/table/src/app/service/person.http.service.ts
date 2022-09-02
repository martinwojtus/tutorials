import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PersonPageRequest } from '../model/person.page.request';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Person } from '../model/person';
import { PageResponse } from '../model/page.response';

const BASE_URL = environment.baseUrl;

@Injectable({
  providedIn: 'root'
})
export class PersonHttpService {

  constructor(private http: HttpClient) {
  }

  personPage(request: PersonPageRequest): Observable<PageResponse<Person>> {
    return this.http.post<PageResponse<Person>>(`${BASE_URL}/api/persons/search`, request);
  }

  find(id: string): Observable<Person> {
    return this.http.get<Person>(`${BASE_URL}/api/persons/${id}`);
  }

  delete(id: string): Observable<any> {
    return this.http.delete<Person>(`${BASE_URL}/api/persons/${id}`);
  }

  save(request: Person): Observable<any> {
    return this.http.put<Person>(`${BASE_URL}/api/persons/${request.id}`, request);
  }

  create(request: Person): Observable<any> {
    return this.http.post<Person>(`${BASE_URL}/api/persons`, request);
  }
}
