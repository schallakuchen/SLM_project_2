import {Component, OnDestroy} from '@angular/core';
import {catchError, of, Subscription, switchMap, timer} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  template: `
      <div *ngIf="openingHours;else noOpeningHours">
          <h1>Opening Hours</h1>
          Monday: {{openingHours.Mo}}<br>
          Tuesday: {{openingHours.Tu}}<br>
          Wednesday: {{openingHours.We}}<br>
          Thursday: {{openingHours.Th}}<br>
          Friday: {{openingHours.Fr}}<br>
          Saturday: {{openingHours.Sa}}<br>
          Sunday: {{openingHours.Su}}
      </div>

      <ng-template #noOpeningHours>
          Opening hours not loaded yet
      </ng-template>
  `
})
export class AppComponent implements OnDestroy {

  subscription: Subscription;

  openingHours: any;

  constructor(private httpClient: HttpClient) {
    this.subscription = timer(0, 5000).pipe(
      switchMap(() => this.httpClient.get<string>("http://localhost:8080/api/hours").pipe(catchError(error => {
        console.log(`Error loading opening hours: ${error}`);
        return of(null);
      }))),
    ).subscribe(openingHours => {
      if (openingHours) {
        this.openingHours = openingHours;
      }
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
