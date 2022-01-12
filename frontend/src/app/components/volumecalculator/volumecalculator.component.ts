import { Component, OnInit, resolveForwardRef } from '@angular/core';
import { map, switchMap, take, tap } from 'rxjs/operators';
import { SessionService } from 'src/app/services/session.service/session.service';
import { VolumeAdjustment } from 'src/app/services/volumeadjustment.service/VolumeAdjustment';
import { VolumeadjustmentService } from 'src/app/services/volumeadjustment.service/volumeadjustment.service';
import { VolumerecommendationService } from 'src/app/services/volumerecommendation.service/volumerecommendation.service';
import { VolumeAdjustmentSelection } from '../../services/volumeadjustment.service/VolumeAdjustmentSelection';

@Component({
  selector: 'app-volumecalculator',
  templateUrl: './volumecalculator.component.html',
  styleUrls: ['./volumecalculator.component.scss']
})
export class VolumecalculatorComponent implements OnInit {

  volumeAdjustmentSelections: VolumeAdjustmentSelection[] = [];

  constructor(
    private sessionService: SessionService,
    private volumeAdjustmentService: VolumeadjustmentService,
    private volumeRecommendation: VolumerecommendationService) {

    this.sessionService.lastUserLogedInSubject.pipe(
      switchMap(user => this.volumeAdjustmentService.getVolumeAdjustmentSelections(user.id, user.genderNumber)))
      .subscribe(res => this.volumeAdjustmentSelections = res);
  }

  ngOnInit(): void {
  }

  selected(event: any) {
    console.log(event);
    let newValue = event as VolumeAdjustment;
    console.log('newValue')
    console.log(newValue)
    let oldValue = this.volumeAdjustmentSelections.find(s => s.volumeProperty == newValue.volumeProperty)?.selectedVolumeAdjustment;
    console.log('oldValue')
    console.log(oldValue)
    this.sessionService.lastUserLogedInSubject.pipe(
      tap(user => {
        console.log(oldValue);
        if (oldValue && oldValue.id !== newValue.id) {
          this.volumeAdjustmentService.removeUser(oldValue.id, user.id).subscribe();
        }
      }),
      tap(user => {
        console.log('addUser')
        if (!oldValue || oldValue.id !== newValue.id) {
          this.volumeAdjustmentService.addUser(newValue.id, user.id).subscribe();
        }
      }),
      take(1)
    ).subscribe(res => console.log(this.volumeAdjustmentSelections));
  }
}
