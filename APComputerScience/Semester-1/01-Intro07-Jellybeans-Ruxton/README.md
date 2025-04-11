Write a program that calculates an integer estimate of the number of jelly beans in a given jar. The program prompts and the user for three inputs - (1) a decimal number for the average length of a jelly bean in cm (2) a decimal number for the average height a jelly bean in cm (3) an integer for the the size of the jar in mLs. (remember one mL equals one cubic centimeter).

Based upon hours of research, zillions of jelly beans, and a bunch of mason jars, I have concluded the volume of a jelly bean can be roughly modeled as the average of the volume of the exterior bounding cylinder and of the volume of the interior bounding ellipsoid and thus the volume of an average jelly bean can be computed by 5 · π · _length · (height^_2 / 24).  Furthermore my research has also determined jelly beans account for 69.8% of the volume of the jar.

_Create a static method to perform the calculation._ 

Sample program run 

```
Enter jelly bean length (cm): **1.5385** 
```

```
Enter jelly bean height (cm): **0.9230** 
```

```
Enter jar size (mL): **500** 
```

```
Estimate for number of jelly beans with average
```

```
length: 1.5385 cm
```

```
height: 0.9230 cm
```

```
in a jar of size 500 mL is
```

```
406
```

Sample program run

```
Enter jelly bean length (cm): **2** 
```

```
Enter jelly bean height (cm): **1** 
```

```
Enter jar size (mL): **25** 
```

```
Estimate for number of jelly beans with average
```

```
length: 2.0 cm
```

```
height: 1.0 cm
```

```
in a jar of size 25 mL is
```

```
13
```

