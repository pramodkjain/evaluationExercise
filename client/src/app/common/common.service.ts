import {Injectable} from "@angular/core";
import {InvoiceForm} from "../invoice/invoice.form";

@Injectable()
export class CommonService {
  public error: string = '';
  public message: string = '';

  public clearErrMsg() {
    this.error = '';
    this.message = '';
  }

  public setError(errMsg: string) {
    this.error = errMsg;
  }

  public setMessage(message: string) {
    this.message = message;
  }

  public handleSuccess(response, msg: string) {
    console.log(JSON.stringify(response));
    this.clearErrMsg();
    this.setMessage(msg);
  }

  public calculateTotal(invoiceForm: InvoiceForm): string {
    var tempTotal: number = 0.00;
    for (let lineItem of invoiceForm.lineItems) {
      tempTotal = Number(tempTotal) + Number(lineItem.amount);
    }
    return tempTotal + "";
  }


  public handleError(error: any) {
    console.log(JSON.stringify(error));
    this.clearErrMsg();
    if (error && error._body) {
      this.setError(error._body);
    } else {
      this.setError("Fatal Error!");
    }
  }


}
