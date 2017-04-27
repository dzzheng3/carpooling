<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="head.jsp"%>
</head>
<body>


	<script type="text/javascript">
function checkPassword(str)
{
  var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
  return re.test(str);
}

function checkForm(form)
{
  if(form.username.value == "") {
    alert("Error: Username cannot be blank!");
    form.username.focus();
    return false;
  }
  re = /^\w+$/;
  if(!re.test(form.username.value)) {
    alert("Error: Username must contain only letters, numbers and underscores!");
    form.username.focus();
    return false;
  }
  if(form.password.value != "" && form.password.value == form.password2.value) {
    if(!checkPassword(form.password.value)) {
      alert("The password you have entered is not valid!");
      form.password.focus();
      return false;
    }
  } else {
    alert("Error: Please check that you've entered and confirmed your password!");
    form.password.focus();
    return false;
  }
  return true;
 }
 
 function checkAge(form){
	 if(!calculateAge(form.dob.value)){
		 alert("You need to be 18 years of age and older!");
		 form.dob.focus();
		 return false;
	 }
	 return true;
 }
 
function calculateAge(dob)
{
    
  var now = new Date();
  var today = now.getFullYear();
 // alert("year====="+today);
  var  age= today - dob;
  alert("age====="+age);
  console.log(today);
  
    if  (age<18)
    {
       
        return false;
    }
    else{
    	return true;
    }

}

</script>

 <div class="site-wrapper">
        <%@include file="header.jsp" %>
        <input>
        <div class="main" role="main">
            <section class="page-content">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-6">
                            <div class="spacer-lg visible-sm visible-xs"></div>
                            <div class="box">
                                <h3>Register</h3>
                                <form action="RegisterServlet" method="POST" role="form" onsubmit="return checkForm(this)&&checkAge(this);">
                                    <div class="form-group">
                                        <label>
                                            Username
                                            <span class="required">*</span>
                                        </label>
                                        <input type="text" name="username" class="form-control" />
                                    </div>
                                     <div class="form-group">
                                        <label>
                                            BirthDate
                                            <span class="required">*</span>
                                        </label>
                                        <input type="text" name="dob" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label>
                                            Gender
                                            <span class="required">*</span>
                                        </label>
                                        <input type="radio" name="gender" value = "1" checked /> Male
                                        <input type="radio" name="gender" value = "2"/> Female
                                       
                                    </div>                                                                                                          <div class="form-group">
                                        <label>
                                            State
                                            <span class="required">*</span>
                                        </label>
                                        <input type="text" name="state" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label>
                                            Zip code
                                            <span class="required">*</span>
                                        </label>
                                        <input type="text" name="zipcode" class="form-control" />
                                    </div>                                    
                                    <div class="form-group">
                                        <label>
                                            Password
                                            <span class="required">*</span>
                                        </label>
                                        <input type="password" name="password" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                    <label>
                                        Confirm Password
                                        <span class="required">*</span>
                                    </label>
                                    <input type="password" name="password2" class="form-control" />
                                	</div>                                       
                                    <div class="form-group">
                                        <label>
                                            Email
                                            <span class="required">*</span>
                                        </label>
                                        <input type="email" name="email" class="form-control" />
                                    </div>
                                    <button type="submit" class="btn btn-primary">Register</button>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-3"></div>
                    </div>
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                </div>
            </section>
            <%@include file="footer.jsp" %>>
        </div>
    </div>
    
</body>
</html>

	