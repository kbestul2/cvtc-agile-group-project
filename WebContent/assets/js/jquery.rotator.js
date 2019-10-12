;(function($, window, undefined) {
  
  'use strict'; //optional
  
  
  //Constructor func for plugin object
  $.FTRotator = function(options, divFeatureRotator) {
    
    //Save passed in DOM element into property that is jQuery object
    this.$divFeatureRotator = $(divFeatureRotator);
    
    //Get started
    this._init(options);
  };
  
  
  //Set up defaults as property of plugin object
  $.FTRotator.defaults = {
    speed: 700,
    easing: 'ease',
    interval: 8000
  };
  
  
  //Define methods the plugin object will have
  $.FTRotator.prototype = {
    
    _init: function(options) {
      
      this.mergedOptions = $.extend($.FTRotator.defaults, options);
      
      this.$items = $(".featureContent");
      
      this.$itemsCount = this.$items.length;
      
      this.currentIndex = 0;
      
      
      //Show current quote
      this.$items.eq(this.currentIndex).addClass('featureCurrent');
      
      if (this.support) {
        
        this._setTransition();
        
      }
      
      //Start rotating quotes
        this._startRotator();
      
    },
    
    _setTransition: function() {
      
      //Right, now "this" refers to $.QTRotator.
      setTimeout($.proxy(function() { //Pass "this" to $.proxy()  as context of the setTimeout function so "this"
        //inside the function still refers to $.QTRotator
        
        this.$items.css('transition', 'opacity ' + this.mergedOptions.speed + 'ms ' + this.mergedOptions.easing);
        
      }, this), 25);
      
    },
    
    _startRotator: function() {
      //Animate progress bar's width fro 0% to 100% ovr time
      if (this.support) {
        this._startProgress();
      }
      
      setTimeout($.proxy(function() {
        
        //Reset progress
        if(this.support){
          this._resetProgressBar();
        }
        
        //Bring in the next quote
        this._nextFeature();
        
        //Start cycle over again
        this._startRotator();
        
      }, this), this.mergedOptions.interval + 25);
      
    
    },
    
    
    _nextFeature: function() {
      
      //Hide current quote
      this.$items.eq(this.currentIndex).removeClass('featureCurrent');
      
      //Get index of next quote using TERNARY operator
      this.currentIndex = this.currentIndex < this.$itemsCount -1 ? this.currentIndex + 1 : 0
      
      //Get the index of next quote
//      if (this.currentIndex < this.$itemsCount -1){
//      this.currentIndex += 1;
//          }else{
//            this.currentIndex = 0;
//          }
      
      //Show next quote
      this.$items.eq(this.currentIndex).addClass('featureCurrent');
    }
    
  };
  
  
  
  
  //Create (define) our plugin method
  //funtion name() {}
  //name = function() {};
  $.fn.ftRotator = function(options) {
    
    if (typeof options === 'string') {
            
            // not as common, leave off code for now...
            
        } else {  // options !== 'string', usually meaning it is an object
            
            // here, this refers the jQuery object that was used
            // to call this plugin method ($('#quoteRotator'))
            this.each(function() {
                
                var instance = $.data(this, 'ftRotator');
                
                if (instance) {
                    instance._init();
                } else {
                    
                  //Call low level jQuery data() method again in setter mode
                  //To create named data store ('qtRotator')
                  //In the DOM on div#quoteRotator
                  instance = $.data(this, 'ftRotator', new $.FTRotator(options, this));
                    
                    
                }
                
            });
            
        }
    
        return this; //makes jQuery method chainable
    
  };
        
}) (jQuery, window);