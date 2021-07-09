package com.umartariq;


interface Accessible { //default package-private  //Default/No Modifier/Package-Private: The access level of a default modifier is only within the package. It cannot be accessed from outside the package. If you do not specify any access level, it will be the default.


    int CONSTANT_LATENCY=100; //default package-private  //Default/No Modifier/Package-Private: The access level of a default modifier is only within the package. It cannot be accessed from outside the package. If you do not specify any access level, it will be the default.
    public void methodA();
    void methodB();
    boolean methodC();

    /*
    The interface body can contain abstract methods, default methods, and static methods. An abstract method within an interface is followed by a semicolon, but no braces (an abstract method does not contain an implementation). Default methods are defined with the default modifier, and static methods with the static keyword. All abstract, default, and static methods in an interface are implicitly public, so you can omit the public modifier.


    In addition, an interface can contain constant declarations. All constant values defined in an interface are implicitly public, static, and final. Once again, you can omit these modifiers.

 */

    //whether you type public access modifier or not, all methods of an interface are public by default
}
