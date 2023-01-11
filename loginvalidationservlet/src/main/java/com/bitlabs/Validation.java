package com.bitlabs;


import com.bitlabs.model.Login;

public class Validation {
public boolean validate(Login login)
{
	boolean b=false;
		  
	
   if(login.getUname().equals("sowjanya") && login.getPwd().equals("123"))
   {
      b=true;
   	}
    return b;
}
}


