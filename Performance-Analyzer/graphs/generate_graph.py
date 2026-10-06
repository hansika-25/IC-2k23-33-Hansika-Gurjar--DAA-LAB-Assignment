import pandas as pd
import matplotlib.pyplot as plt

# Read experimental results
data = pd.read_csv("../performance-results.csv")

# Create performance graph
for algorithm in data["Algorithm"].unique():

    algorithm_data = data[data["Algorithm"] == algorithm]

    plt.plot(
        algorithm_data["Input Size"],
        algorithm_data["Execution Time (ns)"],
        marker="o",
        label=algorithm
    )

plt.xlabel("Input Size")
plt.ylabel("Execution Time (nanoseconds)")
plt.title("Sorting Algorithms Performance Analysis")

plt.legend()
plt.grid(True)

plt.savefig("sorting-performance.png", dpi=300, bbox_inches="tight")

plt.show()