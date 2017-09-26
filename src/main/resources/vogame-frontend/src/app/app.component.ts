import { Component, OnInit } from '@angular/core';
import { StompService } from './stomp.service';
import { LongmanResponse } from './model/longmanResponse';

@Component({
  moduleId: module.id,
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.css'],
  providers: [StompService]
})
export class AppComponent implements OnInit {
  public inputField = '';
  public counter: string;
  public word: string;
  public previousWord: string;
  public definition: LongmanResponse = new LongmanResponse;

  constructor(private _stompService: StompService) {
  }

  public ngOnInit(): void {
    this._stompService.connect('ws://localhost:8181/stompTest');
    this._stompService.getObservable().subscribe(payload => {
      this.counter = payload.content;
    });
    this._stompService.getObservableWord().subscribe(payload => {
      this.word = payload.content;
      this.definition = payload.definition;
      this.previousWord = payload.previousWord;
    });
  }

  public send(): void {
    this._stompService.send(this.inputField);
    this.inputField = '';
  }
}
