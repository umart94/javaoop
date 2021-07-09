package com.umartariq;

/*
The HeavenlyBody class is declared final
 */

/*
WE cannot do this
public class DwarfStars extends HeavenlyBody{
    public DwarfStars(String name, double orbitalPeriod) {
        super(name, orbitalPeriod);
    }
}


heavenlybody class - cannot be subclassed
similiarly string cannot be subclassed

if we apply instanceof operator we don't have to worry about comparisions with a subclass
*/