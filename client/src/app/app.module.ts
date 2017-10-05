import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {InvoiceFormComponent} from "./invoice/invoice.component"
import {AppComponent} from './app.component';
import {CommonService} from "./common/common.service";
import {PreviewInvoiceComponent} from "./invoice/preview/preview.component";
import {NgxTypeaheadModule} from "ngx-typeahead";

@NgModule({
  declarations: [
    AppComponent,
    InvoiceFormComponent,
    PreviewInvoiceComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    NgxTypeaheadModule
  ],
  providers: [CommonService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
