import { Component, OnInit } from '@angular/core';
import { DownloadService } from '../../services/download.service';
import { FileData } from '../../model/file-data';
import { saveAs } from 'file-saver';


@Component({
  selector: 'app-files',
  templateUrl: './files.component.html'
})
export class FilesComponent implements OnInit {

  fileList?: FileData[];

  constructor(private downloadService: DownloadService) {
  }

  ngOnInit(): void {
    this.getFileList();
  }

  getFileList(): void {
    this.downloadService.list().subscribe(result => {
      this.fileList = result;
    });
  }

  downloadFile(fileData: FileData): void {
    this.downloadService
      .download(fileData.filename)
      .subscribe(blob => saveAs(blob, fileData.filename));
  }
}
