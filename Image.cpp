/**
 * @file Image.cpp
 * Created on 09/12/2022
 * 
 * 
 * 
 * © 2022 by Zachary Harris (zacharykeatonharris@gmail.com)
 */

#include "Image.h"

Image::Image():
    width(0),
    height(0)
{
    data.resize(0);
} // end default construtor

Image::Image(const int &height, const int &width):
    width(width),
    height(height);
{
    data.resize(width * height);
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
    if(row > width || row < 0)
    {
        return false;
    } // end if 

    if(column > height || column < 0)
    {
        return false;
    } // end if

    if(channel > 4 || channel < 0)
    {
        return false;
    } // end if 

    return true;
} // end indexValid

int Image::index(const int& row, const int& column, const int& channel) const
{
    int data_index = (row - 1) * width + (column - 1);

    return data_index;
} // end index

int Image::getChannel(const int& row, const int& column, const int& channel) const
{
    if(!indexValid)
    {
        return -1;
    }

    int data_index = (row - 1) * width + (column - 1);

    return this->data[data_index].red;
} // end getChannel

void Image::setHeight(const int &height)
{
    this->height = height;
} // end setHeight

void Image::setWidth(const int &width)
{
    this->width = width;
} // end setWidth

void Image::setChannel(const int& row, const int& column, const int& channel, const int& value)
{
    if(!indexValid)
    {
        return;
    }

    int data_index = (row - 1) * width + (column - 1);

    this->data[data_index].red = value;
} // end setChannel