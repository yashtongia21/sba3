import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Plans } from '../model/plans';

@Injectable({
  providedIn: 'root'
})
export class PlanServiceService {
  baseUrl: string;
  constructor(private http: Http) {
    this.baseUrl = "http://localhost:7070/plans";
  }

  getBaseUrlById(id: number): string {
    return this.baseUrl + "/" + id;
  }

  getSearchUrl(field: string, value: string): string {
    return this.baseUrl + "/" + field + "/" + value;
  }

  getJsonContentTypeHeader(): RequestOptions {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return new RequestOptions({ headers: headers });
  }

  getAllPlans(): Observable<Plans[]> {
    return this.http.get(this.baseUrl).pipe(
      map(data => data.json())
    );
  }

  searchPlans(field: string, value: string): Observable<Plans[]> {
    return this.http.get(this.getSearchUrl(field, value)).pipe(
      map(data => data.json())
    );
  }
}
