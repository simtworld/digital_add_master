<head>
<meta property="og:url"
	content="https://www.your-domain.com/your-page.html" />
<meta property="og:type" content="website" />
<meta property="og:title" content="Your Website Title" />
<meta property="og:description" content="Your description" />
<meta property="og:image"
	content="https://www.your-domain.com/path/image.jpg" />
</head>
<body onload="disableFunctions()">

	<div class="container ms-container">
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">E-Mail Settings</h3>
					</div>
					<div class="form-group align">
						<label>Server Type</label> <br> <label class="radio-inline">
							<input type="radio" name="optradio">SMTP Server
						</label> <label class="radio-inline"> <input type="radio"
							name="optradio">Server Mail (default)
						</label>
					</div>
					<div class="form-group align">
						<label for="inputAddress">SMTP Host</label> <input type="text"
							class="form-control" id="inputAddress"
							placeholder="mail.digitaladds.com">
					</div>
					<div class="form-group align">
						<label for="inputAddress2">SMTP Username</label> <input
							type="text" class="form-control" id="smtp_username"
							placeholder="support@digitaladds.com">
					</div>
					<div class="form-group align">
						<label for="inputAddress2">SMTP Password</label> <input
							type="password" class="form-control" id="smtp_password"
							placeholder="........">
					</div>
					<div class="form-group align">
						<label for="inputAddress2">SMTP Port</label> <input type="number"
							class="form-control" id="inputAddress2" placeholder="1234">
					</div>
					<div class="form-group align">
						<label>SMTP Encryption</label> <br> <label>Server
							Type</label> <br> <label class="radio-inline"> <input
							type="radio" name="optradio">TLS
						</label> <label class="radio-inline"> <input type="radio"
							name="optradio">SSL
						</label>
					</div>
					<div class="form-group align">After clicking "Test message",
						a test message will be sent to your account email address.</div>
					<div style="color: red;" class="form-group align">Please save
						the data before testing the server.</div>
					<div class="form-group align">
						<button type="button" class="btn btn-primary"
							onclick="saveTemplate()">Save</button>
						<button id="testServer" type="button" class="btn btn-warning"
							onclick="sendEMail()" disabled>Test E-Mail Server</button>
					</div>

				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">E-Mail Template</h3>
					</div>
					<div id="custom-select" class="form-group align">
						<label for="comment">Choose Template Type:</label> <select
							class="form-control " id="template-selecter"
							onChange="getTemplateList()">
							<option>Select Template Type...</option>
							<option>Products</option>
							<option>3</option>
							<option>4</option>
						</select>
					</div>
					
					<div id="settings-elements">
						<div class="form-group align">
							<label for="comment">Write your template here:</label>
							<textarea class="form-control" rows="5" id="comment"></textarea>
						</div>
						<!-- <div class="form-group  align">
					<button class="btn btn-info" type="button" onclick="addElement()">
						<span style="color: black" class="glyphicon glyphicon-plus"
							aria-hidden="true"></span>Add Keywords
					</button>
				</div> -->
						<!-- <div  class="form-group">
  					 <div class="input-group">
      					<input type="text" class="form-control" placeholder="Search for...">
      					<span class="input-group-btn">
        					<button class="btn btn-default" type="button" onclick="addElement()">
        						 <span style="color:red" class="glyphicon glyphicon-minus" aria-hidden="true"></span>
        					</button>
      					</span>
   					 </div>		 
  				</div> -->

						<!-- <div class="form-inline align">
							<div class="checkbox">
								<label><input type="checkbox"></label>
							</div>
							<div class="form-group">
								<span> <label>Product Name :</label></span>
								<input type="text" value="Product Name " class="form-control" id="product-name" readonly>
							</div>
							<div class="form-group">
								<input type="text" class="form-control"
									id="product-name-keyword">
							</div>
						</div> -->

						<div id="KeyWordContainer" class=""></div>

						<div class="form-group align">After clicking "Test New
							Template", a test message will be sent to your account email
							address.</div>
						<div style="color: red;" class="form-group align">Please
							save the template before testing the server.</div>
						<div class="form-group align">
							<button type="submit" class="btn btn-primary"
								onclick="changeTemplate()">Change Template</button>
							<button id="testTemplate" type="button" class="btn btn-warning"
								onclick="sendEMail()" disabled>Test New Template</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		function disableFunctions() {
			$('#settings-elements *').prop('disabled', true);
		}
		var intTextBox = 0;
		function getTemplateList() {
			$('#settings-elements *').prop('disabled', false);
			var templateSelecter = document.getElementById("template-selecter").value;
			if (templateSelecter == 'Products') {
				document.getElementById("KeyWordContainer").innerHTML = '<div class="form-inline align">'
						+ '<div class="checkbox "><label><input type="checkbox"></label></div><div class="form-group fp7">'
						+ '<input  type="text" class="form-control"id="product-name-keyword" value="Product Name" readonly></div>'
						+ '<div  class="form-group fp7"><input  type="text" placeholder="Product Name Keyword" class="form-control"id="product-name-keyword"></div></div>'
						+ '<div class="form-inline align">'
						+ '<div class="checkbox "><label><input   type="checkbox"></label></div><div class="form-group fp7">'
						+ '<input  type="text" class="form-control"id="product-name-keyword" value="Product image URL" readonly></div>'
						+ '<div  class="form-group fp7"><input  type="text" placeholder="Image URL keyword" class="form-control"id="product-image-url-keyword"></div></div>'
						+ '<div class="form-inline align">'
						+ '<div class="checkbox "><label><input   type="checkbox"></label></div><div class="form-group fp7">'
						+ '<input  type="text" class="form-control"id="product-name-keyword" value="Product URL" readonly></div>'
						+ '<div  class="form-group fp7"><input  type="text" placeholder="Product URL keyword" class="form-control"id="product-url-keyword"></div></div>'
			}
			if (templateSelecter == 3) {
				document.getElementById("KeyWordContainer").innerHTML = ' <div class="input-group">'
						+ ' <span class="input-group-addon" id="basic-addon1">3</span>'
						+ '<input type="text" class="form-control" placeholder="Keyword Name" aria-describedby="basic-addon1">'
						+ '</div>'
			}
			if (templateSelecter == 4) {
				document.getElementById("KeyWordContainer").innerHTML = ' <div class="input-group">'
						+ ' <span class="input-group-addon" id="basic-addon1">4</span>'
						+ '<input type="text" class="form-control" placeholder="Keyword Name" aria-describedby="basic-addon1">'
						+ '</div>'
			}
		}
		function saveTemplate() {
			document.getElementById("testServer").disabled = false;
			alert("Template saved");
		}
		function sendEMail() {
			alert("A new E-Mail sent");
		}
		function changeTemplate() {
			document.getElementById("testTemplate").disabled = false;
			alert("Template changed");
		}
	</script>
</body>