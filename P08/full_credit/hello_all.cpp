#include <iostream>
#include <cstdlib>

int main()
{
    std::string name{};
    std::cout << "Enter your name: \n";
    std::getline(std::cin >> std::ws, name);
    std::cout << "Hello " << name << "!\n";

    return EXIT_SUCCESS;
}
