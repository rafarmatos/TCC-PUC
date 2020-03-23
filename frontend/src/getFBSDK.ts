///<reference path="../node_modules/@types/facebook-js-sdk/index.d.ts"/>


(<any>window).fbAsyncInit = ()=> {
  FB.init({
    appId            : '280351825936683',
    //autoLogAppEvents : true,
    xfbml            : false,
    version          :  '3.2'
  });
  FB.AppEvents.logPageView();
};

(function(d, s, id){
  let js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) {return;}
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
