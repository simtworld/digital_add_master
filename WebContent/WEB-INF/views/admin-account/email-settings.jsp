

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
					<label for="inputAddress2">SMTP Username</label> <input type="text"
						class="form-control" id="smtp_username"
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
					<label>SMTP Encryption</label> <br> <label>Server Type</label>
					<br> <label class="radio-inline"> <input type="radio"
						name="optradio">TLS
					</label> <label class="radio-inline"> <input type="radio"
						name="optradio">SSL
					</label>
				</div>
				<div class="form-group align">After clicking
					"Test message", a test message will be sent to your account email
					address.</div>
				<div style="color: red;" class="form-group align">Please save
					the data before testing the server.</div>
				<div class="form-group align">
					<button type="button" class="btn btn-primary"onclick="saveTemplate()">Save</button>
					<button id="testServer"type="button" class="btn btn-warning"onclick="sendEMail()" disabled>Test E-Mail
						Server</button>
				</div>

			</div>
		</div>
		<div class="col-md-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">E-Mail Template</h3>
				</div>
				<div class="form-group align">
					<label for="comment">Write your template here:</label>
					<textarea class="form-control" rows="5" id="comment"></textarea>
				</div>
				<div class="form-group align">After clicking
					"Test New Template", a test message will be sent to your account email
					address.</div>
				<div style="color: red;" class="form-group align">Please save
					the template before testing the server.</div>
				<div class="form-group align">
					<button type="button" class="btn btn-primary"onclick="changeTemplate()" >Change Template</button>
					<button id="testTemplate" type="button" class="btn btn-warning"onclick="sendEMail()" disabled>Test New Template</button>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
function saveTemplate() {
	document.getElementById("testServer").disabled = false;
    alert("Template saved");
}
function sendEMail(){
	alert("A new E-Mail sent");
}
function changeTemplate(){
	document.getElementById("testTemplate").disabled = false;
	alert("Template changed");
}
</script>
