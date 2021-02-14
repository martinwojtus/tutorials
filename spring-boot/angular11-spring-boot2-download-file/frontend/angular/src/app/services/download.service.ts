import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { FileData } from '../model/file-data';

@Injectable({
  providedIn: 'root'
})
export class DownloadService {

  constructor(private http: HttpClient) {
  }

  download(file: string | undefined): Observable<Blob> {
    return this.http.get(`${environment.baseUrl}/files/${file}`, {
      responseType: 'blob'
    });
  }

  list(): Observable<FileData[]> {
    return this.http.get<FileData[]>(`${environment.baseUrl}/files`);
  }
}
