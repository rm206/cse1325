#include <iostream>
#include <cstdlib>

int main()
{
    std::string name{};
    std::cout << "Enter your name: " << std::endl;
    std::getline(std::cin >> std::ws, name);
    std::cout << "Hello " << name << "!" << std::endl;

    return EXIT_SUCCESS;
}
