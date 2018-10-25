import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string;
  field: string = "netSpeed";
  srchValue: string = "";
  constructor(private router: Router) {
    this.title = "Tarangini Limited";
  }

  doSearch() {
    this.router.navigate(["/listPlans"], { queryParams: { field: this.field, srchValue: this.srchValue } });
  }

  doChangeField(field, ele) {
    this.field = field;
    this.srchValue = "";
    switch (field) {
      case 'netSpeed': ele.placeholder = "Net Speed"; ele.type = "text"; break;
      case 'maxUsage': ele.placeholder = "Maximum Usage done"; ele.type = "text"; break;
      case 'charge': ele.placeholder = "Data Rates"; ele.type = "text"; break;
    }
  }

}
