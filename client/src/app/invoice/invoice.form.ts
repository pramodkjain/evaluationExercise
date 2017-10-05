import {LineItem} from "./line-item.form";
export class InvoiceForm {
  constructor(public invoiceID:number,public name: string, public email: string,
              public dueDate: Date, public lineItems: LineItem[]) {
  }
}
