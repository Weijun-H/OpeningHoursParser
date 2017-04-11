# OpeningHoursParser

This is a very simplistic parser for string values according to the [OSM opening hours specification][opening-hours-specification].

It parses 145'447 (90%) of 161'268 unique test strings in non-strict mode. The remaining 15'821 are likely valid errors, spot checking shows that they have obvious issues. In strict mode further 20'416 fail (total 36'543).

Deviations from the grammar as of [this version of the opening hours specification][opening-hours-grammar-specification] in all modes:

 * case insensitive
 * leading 0s in times optional
 * unicode EN DASH character is allowed for hyphen

In non-strict mode the following further differences are allowed:

 * three-character weekday abbreviations
 * German two-letter weekday abbreviations
 * times extending in to the next day that are missing the extra 24 hours are corrected
 * single 0 for minutes
 * minutes in times optional
 * AM and PM time specifications are allowed
 * holidays following weekdays
 * 24/7 rules with preceding selectors are corrected to 00:00-24:00 time spans

Converting the data structures generated by parsing back to strings will result in correct data according to the specification.

## Usage

``` java
try {
	OpeningHoursParser parser = new OpeningHoursParser(
		new ByteArrayInputStream(line.getBytes()));
	ArrayList<Rule> rules = parser.rules(strict);
	// ...
} catch() {
	// ...
}
```

## Including in your project

You can either download the *jar* from GitHub or add the following to your *build.gradle* file(s):

``` groovy
repositories {
    maven {
    	jcenter()
    }
}
```

``` groovy
dependencies {
    compile "ch.poole:OpeningHoursParser:0.1.2"
}
```


[opening-hours-specification]: http://wiki.openstreetmap.org/wiki/Key:opening_hours/specification
[opening-hours-grammar-specification]: http://wiki.openstreetmap.org/w/index.php?title=Key:opening_hours/specification&oldid=1075290
