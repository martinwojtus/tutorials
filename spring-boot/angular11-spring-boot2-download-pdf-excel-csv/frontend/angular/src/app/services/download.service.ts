import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

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
}
