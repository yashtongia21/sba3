import { Component, OnInit } from '@angular/core';
import { Plans } from '../../model/plans';
import { PlanServiceService } from '../../service/plan-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-list-plans',
  templateUrl: './list-plans.component.html',
  styleUrls: ['./list-plans.component.css']
})
export class ListPlansComponent implements OnInit {

  plans: Plans[];

  constructor(private planService: PlanServiceService
    , private activatedRoute: ActivatedRoute) { }

  ngOnInit() {

    this.activatedRoute.queryParams.subscribe(
      (params) => {
        let field = params['field'];
        let srchValue = params['srchValue'];

        if (field && srchValue) {
          this.planService.searchPlans(field, srchValue).subscribe(
            (data) => this.plans = data
          );
        } else {
          this.planService.getAllPlans().subscribe(
            (data) => this.plans = data
          );
        }
      }
    );

  }

}
