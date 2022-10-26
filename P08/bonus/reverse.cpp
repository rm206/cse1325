#include <iostream>
#include <cstdlib>
#include <algorithm>

int main(int argc, char *argv[])
{
    for(int i = 1 ; i < argc ; i++)
    {
        std::string temp {argv[i]};
        std::reverse(temp.begin(), temp.end());
        std::cout << temp << "\n";
    }

    return EXIT_SUCCESS;
}