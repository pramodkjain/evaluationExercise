import {Http, Headers} from '@angular/http';
import {Component} from "@angular/core";
import {InvoiceForm} from "./invoice.form";
import {LineItem} from "./line-item.form";
import {CommonService} from "../common/common.service";

@Component({
  selector: 'invoice-form',
  templateUrl: './invoice.html'
})
export class InvoiceFormComponent {

  public model = new InvoiceForm(0, '', '', null, new Array<LineItem>());
  public total: string = "0.00";

  constructor(public http: Http, private commonService: CommonService) {
    this.model.lineItems.push(new LineItem(0, '', '0.00'));
  }

  public submit() {
    console.log(JSON.stringify(this.model));
    let headers = new Headers({'Content-Type': 'application/json'});
    this.http
      .post('/api/invoice', JSON.stringify(this.model), {headers: headers})
      .subscribe(
        response => this.handleSaveInvoiceSucess(response),
        error => this.commonService.handleError(error),
        () => console.log('Rest API call complete!')
      );
  }

  private handleSaveInvoiceSucess(response: any) {
    if(this.model.invoiceID === response.json().invoiceID){
      this.commonService.handleSuccess(response, "Invoice modified successfully!")
    }else{
      this.commonService.handleSuccess(response, "Invoice created successfully!")
    }
    this.model = response.json();
  }

  public addNewRow() {
    console.log(this.model);
    this.model.lineItems.push(new LineItem(0, '', '0.00'));
  }

  public calculateTotal(): void {
    this.total = this.commonService.calculateTotal(this.model);
  }

  public urlLineItemSuggest = '/api/lineItem/suggest';
  public urlInvoiceNameSuggest = '/api/invoiceName/suggest';

  handleInvoiceSelected(result) {
    let headers = new Headers({'Content-Type': 'application/json'});
    this.http
      .get('/api/invoice/' + result, {headers: headers})
      .subscribe(
        response => this.model = response.json(),
        error => this.commonService.handleError(error),
        () => this.calculateTotal()
      );
  }


  handleLineItemSelected(result, index) {
    this.model.lineItems[index].description = result;
  }
}
