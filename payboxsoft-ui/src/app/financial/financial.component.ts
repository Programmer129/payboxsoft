import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {PayBoxService} from '../service/paybox.service';
import {NgForm} from '@angular/forms';
import {Utils} from '../utils';

@Component({
  selector: 'app-financial',
  templateUrl: './financial.component.html',
  styleUrls: ['./financial.component.css']
})
export class FinancialComponent implements OnInit {

  private service = 'CHARITY';
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
      const accountNumber = form.value.accountNumber;
      const personalNumber = form.value.personalNumber;
      const mobileNumber = form.value.mobileNumber;
      const amount = form.value.amount;
      this.payboxService
        .transferToFinancials(accountNumber, personalNumber, mobileNumber, Utils.toSmallerUnit(amount), this.service)
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
