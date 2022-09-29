/**
 * @file Image.cpp
 * Created on 09/12/2022
 * 
 * 
 * 
 * © 2022 by Zachary Harris (zacharykeatonharris@gmail.com)
 */

#include "Image.h"
#include <iostream>
#include <cmath>

Image::Image():
    width(0),
    height(0)
{
    data.resize(0);
} // end default construtor

Image::Image(const int &height, const int &width):
    width(width),
    height(height),
    data(width * height, Pixel())
{
    
} // end initializing constructor

int Image::getHeight() const
{
    return this->height;
} // end getHeight

int Image::getWidth() const
{
    return this->width;
} // end getWidth

bool Image::indexValid(const int& row, const int& column, const int& channel) const
{
    if(row >= width || row < 0)
    {
        return false;
    } // end if 

    if(column >= height || column < 0)
    {
        return false;
    } // end if

    if(channel >= NUMBER_OF_CHANNELS || channel < 0)
    {
        return false;
    } // end if 

    return true;
} // end indexValid

int Image::index(const int& row, const int& column) const
{
    int data_index = (width * column) + row;

    return data_index;
} // end index

int Image::getChannel(const int& row, const int& column, const int& channel) const
{
    if(!indexValid(row, column, channel))
    {
        return -1;
    }

    int data_index = index(row, column);

    return this->data[data_index].channels[channel];
} // end getChannel

void Image::setHeight(const int &height)
{
    this->height = height;

    int size = width * height;

    data.resize(size);
} // end setHeight

void Image::setWidth(const int &width)
{
    this->width = width;

    int size = width * height;

    data.resize(size);
} // end setWidth

void Image::setChannel(const int& row, const int& column, const int& channel, const int& value)
{
    if(!indexValid(row, column, channel))
    {
        return;
    }

    int data_index = index(row, column);

    this->data[data_index].channels[channel] = value;
} // end setChannel

void Image::print()
{
    std::vector<std::string> textures(9);
    textures[0] = ".";
    textures[1] = "-";
    textures[2] = ":";
    textures[3] = "=";
    textures[4] = "+";
    textures[5] = "%";
    textures[6] = "*";
    textures[7] = "@";
    textures[8] = "#";
    
    for(int y = 0; y < height; y++) {
        for(int x = 0; x < width; x++) {
            //std::cout << "Pixel(" << i << "," << j << ")\n  R: " << getChannel(i,j,0) << "; G: " << getChannel(i,j,1) << "; B: " << getChannel(i,j,2) << "; A: " << getChannel(i,j,3) << "\n";
            int index = std::floor(getChannel(x, y, 0) / 26);

            std::cout << textures[index];
        }
        std::cout << "\n";
    }
} // end print