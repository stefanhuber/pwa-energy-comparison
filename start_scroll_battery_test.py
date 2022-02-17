import argparse
import time
import helper.adb as adb

# native: fdroid, newpipe, tinyweather
# react: 'bustimetable', 'ulangi', 'yummeals'
# flutter: 'flutterebook', 'metalreleases', 'allman'
# hybrid: 'sworkit', 'justwatch', 'untapped'
# firefox: 'aliexpressfirefox', 'letgofirefox', 'swiggyfirefox'
# chrome: 'aliexpress', 'letgo', 'swiggy'

parser = argparse.ArgumentParser(description='Swipe Test')
parser.add_argument('-i', '--ip', type=str, help='IP-Address of adb-connected Android device', default="")
parser.add_argument('-a', '--app', type=str, help='Name of app', default="test")
parser.add_argument('-p', '--port', type=str, help='Port of adb-connected Android device', default="")
parser.add_argument('-n', '--count', type=int, help='Number of executions of a test per app', default=1)
parser.add_argument('-s', '--start', type=int, help='Start index of test', default=1)

args = parser.parse_args()
device = adb.get_connected_device(args.ip, args.port)
count = args.count
start = args.start
name = args.app

# interaction: interaction class name, energy metering True/False

interactions = [
    ["ScrollDownListInteractionTest", True],
    ["ScrollUpListInteractionTest", True],
]

for n in range(start, start + count):
    print("start run: {} of {}".format(n, (start + count - 1)))

    time.sleep(5)

    for interaction in interactions:

        if interaction[1]:
            adb.clear_batterystats()

        adb.start_instrumentation("at.stefanhuber.instrumentation", interaction[0])

        if interaction[1]:
            adb.dump_batterystats()
            adb.pull_data("/data/local/tmp/battery.txt",
                          "./data/real_world_apps/battery_{}_{}_{}_{}.txt".format(device, name, interaction[0], n))
