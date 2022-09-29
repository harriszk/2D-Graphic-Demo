/**
 * @file driver.cpp
 * Created on 09/12/2022
 * 
 * 
 * 
 * © 2022 by Zachary Harris (zacharykeatonharris@gmail.com)
 */

#include "Image.h"
#include <iostream>

int main()
{
    Image image(4, 4);

    image.setChannel(1,0,0,0x1c);
    image.setChannel(1,1,0,0x1c);
    image.setChannel(1,2,0,0x1c);
    image.setChannel(1,3,0,0x1c);
    image.setChannel(2,0,0,0x4f);
    image.setChannel(2,1,0,0x4f);
    image.setChannel(2,2,0,0x4f);
    image.setChannel(2,3,0,0x4f);
    image.setChannel(3,0,0,0x4f);
    image.setChannel(3,1,0,0x4f);
    image.setChannel(3,2,0,0x4f);
    image.setChannel(3,3,0,0x4f);
    
    image.print();

    image.setWidth(4);
    
    return 0;
} // end main