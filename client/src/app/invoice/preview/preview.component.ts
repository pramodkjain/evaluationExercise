
import {Component, Input} from "@angular/core";
import {InvoiceForm} from "../invoice.form";
import {CommonService} from "../../common/common.service";

@Component({
  selector:'invoice-preview',
  templateUrl:'./preview.html'
})
export class PreviewInvoiceComponent{

  @Input() invoice : InvoiceForm;

  constructor(private commonService: CommonService){
  }

  public calculateTotal():string{
    return this.commonService.calculateTotal(this.invoice)+"";
  }


}
