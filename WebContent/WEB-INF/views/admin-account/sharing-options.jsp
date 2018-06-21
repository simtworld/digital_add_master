

<body>
	<div class="ms-container-for-sharing-options">
		<!-- <p id="button">Share</p> -->
		<button id="button" class="btn btn-primary">
			<i class="fa fa-facebook-f" style="color: white; padding-right: 7px"></i>Share
		</button>
		<blockquote class="instagram-media"
			data-instgrm-permalink="https://www.instagram.com/p/BhqTqHNA1RY/"
			data-instgrm-version="8"
			style="background: #FFF; border: 0; border-radius: 3px; box-shadow: 0 0 1px 0 rgba(0, 0, 0, 0.5), 0 1px 10px 0 rgba(0, 0, 0, 0.15); margin: 1px; max-width: 658px; padding: 0; width: 99.375%; width: -webkit-calc(100% - 2px); width: calc(100% - 2px);">
			<div style="padding: 8px;">
				<div
					style="background: #F8F8F8; line-height: 0; margin-top: 40px; padding: 51.71296296296296% 0; text-align: center; width: 100%;">
					<div
						style="background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACwAAAAsCAMAAAApWqozAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAMUExURczMzPf399fX1+bm5mzY9AMAAADiSURBVDjLvZXbEsMgCES5/P8/t9FuRVCRmU73JWlzosgSIIZURCjo/ad+EQJJB4Hv8BFt+IDpQoCx1wjOSBFhh2XssxEIYn3ulI/6MNReE07UIWJEv8UEOWDS88LY97kqyTliJKKtuYBbruAyVh5wOHiXmpi5we58Ek028czwyuQdLKPG1Bkb4NnM+VeAnfHqn1k4+GPT6uGQcvu2h2OVuIf/gWUFyy8OWEpdyZSa3aVCqpVoVvzZZ2VTnn2wU8qzVjDDetO90GSy9mVLqtgYSy231MxrY6I2gGqjrTY0L8fxCxfCBbhWrsYYAAAAAElFTkSuQmCC); display: block; height: 44px; margin: 0 auto -44px; position: relative; top: -22px; width: 44px;"></div>
				</div>
				<p
					style="color: #c9c8cd; font-family: Arial, sans-serif; font-size: 14px; line-height: 17px; margin-bottom: 0; margin-top: 8px; overflow: hidden; padding: 8px 0 7px; text-align: center; text-overflow: ellipsis; white-space: nowrap;">
					<a href="https://www.instagram.com/p/BhqTqHNA1RY/"
						style="color: #c9c8cd; font-family: Arial, sans-serif; font-size: 14px; font-style: normal; font-weight: normal; line-height: 17px; text-decoration: none;"
						target="_blank">A post shared by Chinmaya Lenkaa
						(@chinmaya_lenka)</a> on
					<time
						style="font-family: Arial, sans-serif; font-size: 14px; line-height: 17px;"
						datetime="2018-04-17T06:12:08+00:00">Apr 16, 2018 at
						11:12pm PDT</time>
				</p>
			</div>
		</blockquote>

		<a href="https://twitter.com/share?ref_src=twsrc%5Etfw"
			class="twitter-share-button" data-show-count="true">Tweet</a> <a
			class="twitter-share-button" href="https://twitter.com/share"
			data-size="small" data-url="http://knoldus.com" data-text="Hello"
			data-count="none">Tweet</a>
		<script async src="https://platform.twitter.com/widgets.js"
			charset="utf-8"></script>
		<script async defer src="//www.instagram.com/embed.js"></script>
		<script>
			window.twttr = (function(d, s, id) {
				var js, fjs = d.getElementsByTagName(s)[0], t = window.twttr
						|| {};
				if (d.getElementById(id))
					return;
				js = d.createElement(s);
				js.id = id;
				js.src = "https://platform.twitter.com/widgets.js";
				fjs.parentNode.insertBefore(js, fjs);
				t._e = [];
				t.ready = function(f) {
					t._e.push(f);
				};
				return t;
			}(document, "script", "twitter-wjs"));
			twttr.events.bind('tweet', function(event) {
				// do somethings here
				alert("Tweet has been successfully posted");
			});
		</script>


		<script>
			(function(d, s, id) {
				var js, fjs = d.getElementsByTagName(s)[0];
				if (d.getElementById(id)) {
					return;
				}
				js = d.createElement(s);
				js.id = id;
				js.src = "//connect.facebook.net/en_US/sdk.js";
				fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'facebook-jssdk'));
			window.fbAsyncInit = function() {
				FB.init({
					appId : '12345676890',
					status : true,
					xfbml : true,
					version : 'v2.1'
				});

				window.facebookShare = function(callback) {

					var options = ({
						method : 'share',
						href : 'url goes here'
					}), status = '';

					FB.ui(options, function(response) {

						if (response && !response.error_code) {
							status = 'success';
							$.event.trigger('fb-share.success');

						} else {
							status = 'error';
							$.event.trigger('fb-share.error');
						}

<div class="ms-container-for-sharing-options">
	<iframe
		src="https://www.facebook.com/plugins/share_button.php?href=http%3A%2F%2Famzn.to%2F2I2UeHS%2F%23%2F&layout=button&size=large&mobile_iframe=true&width=73&height=28&appId"
		width="73" height="28" style="border: none; overflow: hidden"
		scrolling="no" frameborder="0" allowTransparency="true"
		allow="encrypted-media"></iframe>
	<iframe
		src="https://www.facebook.com/plugins/share_button.php?href=https%3A%2F%2Famzn.to%2F2I2UeHS&layout=button_count&size=small&mobile_iframe=true&appId=185524568774474&width=86&height=20"
		width="86" height="20" style="border: none; overflow: hidden"
		scrolling="no" frameborder="0" allowTransparency="true"
		allow="encrypted-media"></iframe>

</div>

						if (callback && typeof callback === "function") {
							callback.call(this, status);
						} else {
							return response;
						}
					});
				}
<script
	src="//platform-api.sharethis.com/js/sharethis.js#property=5b2382882337c30011a5b74f&product=inline-share-buttons"></script>
<div class="sharethis-inline-share-buttons"></div>


<body>
	<div class="ms-container-for-sharing-options">
		<!-- <p id="button">Share</p> -->

		<blockquote class="instagram-media"
			data-instgrm-permalink="https://www.instagram.com/p/BhqTqHNA1RY/"
			data-instgrm-version="8"
			style="background: #FFF; border: 0; border-radius: 3px; box-shadow: 0 0 1px 0 rgba(0, 0, 0, 0.5), 0 1px 10px 0 rgba(0, 0, 0, 0.15); margin: 1px; max-width: 658px; padding: 0; width: 99.375%; width: -webkit-calc(100% - 2px); width: calc(100% - 2px);">
			<div style="padding: 8px;">
				<div
					style="background: #F8F8F8; line-height: 0; margin-top: 40px; padding: 51.71296296296296% 0; text-align: center; width: 100%;">
					<div
						style="background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACwAAAAsCAMAAAApWqozAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAMUExURczMzPf399fX1+bm5mzY9AMAAADiSURBVDjLvZXbEsMgCES5/P8/t9FuRVCRmU73JWlzosgSIIZURCjo/ad+EQJJB4Hv8BFt+IDpQoCx1wjOSBFhh2XssxEIYn3ulI/6MNReE07UIWJEv8UEOWDS88LY97kqyTliJKKtuYBbruAyVh5wOHiXmpi5we58Ek028czwyuQdLKPG1Bkb4NnM+VeAnfHqn1k4+GPT6uGQcvu2h2OVuIf/gWUFyy8OWEpdyZSa3aVCqpVoVvzZZ2VTnn2wU8qzVjDDetO90GSy9mVLqtgYSy231MxrY6I2gGqjrTY0L8fxCxfCBbhWrsYYAAAAAElFTkSuQmCC); display: block; height: 44px; margin: 0 auto -44px; position: relative; top: -22px; width: 44px;"></div>
				</div>
				<p
					style="color: #c9c8cd; font-family: Arial, sans-serif; font-size: 14px; line-height: 17px; margin-bottom: 0; margin-top: 8px; overflow: hidden; padding: 8px 0 7px; text-align: center; text-overflow: ellipsis; white-space: nowrap;">
					<a href="https://www.instagram.com/p/BhqTqHNA1RY/"
						style="color: #c9c8cd; font-family: Arial, sans-serif; font-size: 14px; font-style: normal; font-weight: normal; line-height: 17px; text-decoration: none;"
						target="_blank">A post shared by Chinmaya Lenkaa
						(@chinmaya_lenka)</a> on
					<time
						style="font-family: Arial, sans-serif; font-size: 14px; line-height: 17px;"
						datetime="2018-04-17T06:12:08+00:00">Apr 16, 2018 at
						11:12pm PDT</time>
				</p>
			</div>
		</blockquote>


		<a class="btn twitter"
			href="https://twitter.com/intent/tweet?url=https://amzn.to/2I2UeHS &status=This%20photo%20is%20awesome!%20Check%20it%20out:%20pic.twitter.com/9Ee63f7aVp">Share
			on Twitter</a>
		<script type="text/javascript">
			window.twttr = (function(d, s, id) {
				var js, fjs = d.getElementsByTagName(s)[0], t = window.twttr
						|| {};
				if (d.getElementById(id))
					return;
				js = d.createElement(s);
				js.id = id;
				js.src = "https://platform.twitter.com/widgets.js";
				fjs.parentNode.insertBefore(js, fjs);

				t._e = [];
				t.ready = function(f) {
					t._e.push(f);
				};

				return t;
			}(document, "script", "twitter-wjs"));

		

			function tweetIntentToAnalytics(intentEvent) {
				if (!intentEvent)
					return;
				alert("hello tweeter--pass>");
				var label = "tweet";
				pageTracker._trackEvent('twitter_web_intents',
						intentEvent.type, label);
			}

		
			// Wait for the asynchronous resources to load
			twttr.ready(function(twttr) {
				// Now bind our custom intent events
				twttr.events.bind('click', clickEventToAnalytics);
				twttr.events.bind('tweet', tweetIntentToAnalytics);
				twttr.events.bind('retweet', retweetIntentToAnalytics);
				twttr.events.bind('like', likeIntentToAnalytics);
				twttr.events.bind('follow', followIntentToAnalytics);
			});
		</script>



		<script async defer src="//www.instagram.com/embed.js"></script>


		<!-- pinterest -->
		<script async defer src="//assets.pinterest.com/js/pinit.js">
			
		</script>

	<!-- script for uri encoding of pinterest to be used in ajax call of next product add button in share product modal -->
		<!-- <script>
			function myFunction() {
				var uri = "https://hniesfp.imgix.net/8/images/detailed/69/Y3V76EAABU_01.jpg";
				var res = encodeURIComponent(uri);
				document.getElementById("demo").innerHTML = res;
			}
		</script> -->

		<a data-pin-do="buttonBookmark"
			href="https://www.pinterest.com/pin/create/button/?url=https%3A%2F%2Famzn.to%2F2I2UeHS&media=https%3A%2F%2Fhniesfp.imgix.net%2F8%2Fimages%2Fdetailed%2F69%2FY3V76EAABU_01.jpg&description=SB%20welcometomysite target="
			blank" class="pinterest-anchorpinterest-hidden"></a>



		<button id="button" class="btn btn-primary">
			<i class="fa fa-facebook-f" style="color: white; padding-right: 7px"></i>Share
		</button>

		<script>
			(function(d, s, id) {
				var js, fjs = d.getElementsByTagName(s)[0];
				if (d.getElementById(id)) {
					return;
				}
				js = d.createElement(s);
				js.id = id;
				js.src = "//connect.facebook.net/en_US/sdk.js";
				fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'facebook-jssdk'));
			window.fbAsyncInit = function() {
				FB.init({
					appId : '1704765292925226',
					status : true,
					xfbml : true,
					version : 'v2.1'
				});

				window.facebookShare = function(callback) {

					var options = ({
						method : 'share',
						href : 'https://amzn.to/2I2UeHS'
					}), status = '';

					FB.ui(options, function(response) {

						if (response && !response.error_code) {
							status = 'success';
							$.event.trigger('fb-share.success');

						} else {
							status = 'error';
							$.event.trigger('fb-share.error');
						}

						if (callback && typeof callback === "function") {
							callback.call(this, status);
						} else {
							return response;
						}
					});
				}

			};

			$('#button').on('click', function(e) {
				e.preventDefault();

				facebookShare(function(response) {
					// simple function callback
					console.log(response);
				});
			});

			// custom jQuery events
			$(document).on('fb-share.success', function(e) {
				alert("succeed");
			}).on('fb-share.error', function(e) {
				alert("fail");
			});
		</script>
	</div>
</body>
		