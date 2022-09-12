/**
 * @file Image.h
 * Created on 09/12/2022
 * 
 * 
 * 
 * © 2022 by Zachary Harris (zacharykeatonharris@gmail.com)
 */

#ifndef _IMAGE_H_
#define _IMAGE_H_

#include <vector>

struct Pixel {
    int red;
    int green;
    int blue;
    int alpha;
};

/**
 * 
 * 
 */
class Image {
    public:
        // Default constructor
        Image();

        // Initializing constructor
        Image(const int &height, const int &width);

        // Returns the height of the Image.
        int getHeight() const;

        // Returns the width of the Image.
        int getWidth() const;

        // Checks if row, column, and channel are all within the legal limits. Returns true if they all are, and false otherwise.
        bool indexValid( const int& row, const int& column, const int& channel ) const;

        // Returns the index into the data vector for the location specified by row, column, and channel.
        int index( const int& row, const int& column, const int& channel ) const;

        //  Returns an int representation of the value in the data vector at the location specified by row, 
        // column, and channel. Uses the index method. Returns -1 if the row, column, or channel is not valid. 
        // Uses the indexValid method to check.
        int getChannel( const int& row, const int& column, const int& channel ) const;

        // Change the height of the Image. The state of any new or existing pixels after this call is undetermined.
        // Only non-negative values of height should be accepted. If the value is not accepted, make no changes. 
        // If a change is made, be sure to resize the data vector.
        void setHeight( const int& height );

        // Change the width of the Image. The state of any new or existing pixels after this call is undetermined.
        // Only non-negative values of width should be accepted. If the value is not accepted, make no changes.
        // If a change is made, be sure to resize the data vector.
        void setWidth( const int& width );

        // Change the value of the location specified by row, column, and channel. Only store if the row, column, 
        // and channel are valid (uses indexValid to check). If any of these is not valid, no changes should be made. 
        // Uses the index method to calculate the location.
        void setChannel( const int& row, const int& column, const int& channel, const int& value );
    private:
        int width;

        int height;

        std::vector<Pixel> data;
}; // end Image

#include "Image.cpp"

#endif