if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'knote-js'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'knote-js'.");
}
this['knote-js'] = function (_, Kotlin) {
  'use strict';
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var print = Kotlin.kotlin.io.print_s8jyv4$;
  function Note(title) {
    this.title = title;
  }
  Note.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Note',
    interfaces: []
  };
  Note.prototype.component1 = function () {
    return this.title;
  };
  Note.prototype.copy_61zpoe$ = function (title) {
    return new Note(title === void 0 ? this.title : title);
  };
  Note.prototype.toString = function () {
    return 'Note(title=' + Kotlin.toString(this.title) + ')';
  };
  Note.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.title) | 0;
    return result;
  };
  Note.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.title, other.title))));
  };
  function main(args) {
    print(new Note('Hello world'));
  }
  _.Note = Note;
  _.main_kand9s$ = main;
  main([]);
  Kotlin.defineModule('knote-js', _);
  return _;
}(typeof this['knote-js'] === 'undefined' ? {} : this['knote-js'], kotlin);
