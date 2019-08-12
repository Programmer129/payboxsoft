import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {NgForm} from '@angular/forms';
import {PayBoxService} from '../service/paybox.service';
import {Utils} from '../utils';

@Component({
  selector: 'app-mobile',
  templateUrl: './mobile.component.html',
  styleUrls: ['./mobile.component.css']
})
export class MobileComponent implements OnInit {

  private service = 'MOBILE';
  error;
  total;
  commission;
  transferSuccess;

  @ViewChild('amount') amount: ElementRef;

  constructor(private payboxService: PayBoxService) {
  }

  ngOnInit() {
  }

  onTransfer(form: NgForm) {
    if (form) {
      this.payboxService.transferToMobile(form.value.mobileNumber, Utils.toSmallerUnit(form.value.amount), this.service)
        .subscribe(response => {
          this.transferSuccess = true;
          this.error = null;
          setTimeout(() => {
              location.reload();
          }, 1000);
        }, error1 => this.error = error1);
    }
  }

  getPrePrice() {
    // @ts-ignore
    this.payboxService.getPrePrice(Utils.toSmallerUnit(this.amount.value.toString()), this.service)
      .subscribe(response => {
        // @ts-ignore
        this.total = Utils.toGeorgianLari(response.total);
        // @ts-ignore
        this.commission = Utils.toGeorgianLari(response.commission);
      }, (error1 => {
        this.error = error1;
      }));
  }
}
