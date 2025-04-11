docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" selenium/standalone-chrome:latest
:: option --detach or -d , means that a Docker container runs in the background of your terminal
:: -p -port localMachinePort:containerPort
:: Docker shm size refers to the amount of shared memory allotted to a docker container