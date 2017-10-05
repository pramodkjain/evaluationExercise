import {Component} from "@angular/core";
import {CommonService} from "./common/common.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.html'
})
export class AppComponent {


  constructor(private commonService:CommonService) {
  }

  public clearErrMsg(){
    this.commonService.clearErrMsg();
  }

  public getErrorMessage():string{
    return this.commonService.error;
  }

  public getMessage():string{
    return this.commonService.message;
  }

}
