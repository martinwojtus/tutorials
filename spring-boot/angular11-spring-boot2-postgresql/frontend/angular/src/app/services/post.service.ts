import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Post } from '../model/post.model';

const baseUrl = 'http://localhost:8080/api/posts';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) {
  }

  list(): Observable<any> {
    return this.http.get(baseUrl);
  }

  get(id: string): Observable<any> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data: Post): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: string, data: Post): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  publishUnpublish(id: string, data: Post): Observable<any> {
    return this.http.put(`${baseUrl}/${id}/publish`, data);
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  findByTitle(title: string): Observable<any> {
    return this.http.get(`${baseUrl}?title=${title}`);
  }
}
