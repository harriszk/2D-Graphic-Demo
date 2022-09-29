#define MAX_PIXEL_VALUE 0xFF
#define NUMBER_OF_CHANNELS 4

#include <stdexcept>

struct Pixel {
    // Default constructor
    Pixel();

    // Initializing constructor
    Pixel(const int& R, const int& G, const int& B, const int& A);

    // Destructor
    ~Pixel();

    /**
     * Channel Orders:
     *   0 = Red
     *   1 = Green
     *   2 = Blue
     *   3 = Alpha
     */
    int channels[NUMBER_OF_CHANNELS];
}; // end Pixel struct

Pixel::Pixel()
{
    channels[0] = 0x00;
    channels[1] = 0x00;
    channels[2] = 0x00;
    channels[3] = 0x00;
} // end default constructor

Pixel::Pixel(const int& R, const int& G, const int& B, const int& A)
{
    if(R > MAX_PIXEL_VALUE || G > MAX_PIXEL_VALUE || B > MAX_PIXEL_VALUE || A > MAX_PIXEL_VALUE)
    {
        channels[0] = 0x00;
        channels[1] = 0x00;
        channels[2] = 0x00;
        channels[3] = 0x00;
        return;
    } // end if

    channels[0] = R;
    channels[1] = G;
    channels[2] = B;
    channels[3] = A;
} // end intializing constructor

Pixel::~Pixel(void)
{

} // end destructor