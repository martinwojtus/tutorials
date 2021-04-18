import { Component } from '@angular/core';
import { DownloadService } from '../../services/download.service';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-files',
  templateUrl: './files.component.html'
})
export class FilesComponent {

  constructor(private downloadService: DownloadService) {
  }

  downloadFile(filename: string): void {
    this.downloadService
      .download(filename)
      .subscribe(blob => saveAs(blob, filename));
  }
}
