import { Component } from '@angular/core';
import { environment } from '../environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ]
})
export class AppComponent {
  title = 'angular';

  pdfList: any[] = environment.pdfs;
  pdfDocumentSrc: any = environment.pdfs[0];
  page: number = 1;
  totalPages: number = 0;
  isLoaded: boolean = false;

  afterLoadComplete(pdfData: any) {
    this.totalPages = pdfData.numPages;
    this.isLoaded = true;
  }

  nextPage() {
    this.page++;
  }

  prevPage() {
    this.page--;
  }

  showPdf(pdfFile: any, $event: any) {
    this.pdfList.forEach(pdf => pdf.selected = false);
    pdfFile.selected = true;
    this.pdfDocumentSrc = pdfFile;
    $event.preventDefault();
  }
}
