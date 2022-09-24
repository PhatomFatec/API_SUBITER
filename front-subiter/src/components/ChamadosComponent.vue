
<template>
  <div>
    <div class="card">
      <h5>Session Storage</h5>
      <DataTable
        :value="customers"
        :paginator="true"
        :rows="10"
        v-model="filters1"
        v-model1="selectedCustomer1"
        selectionMode="single"
        dataKey="id"
        stateStorage="session"
        stateKey="dt-state-demo-session"
        responsiveLayout="scroll"
      >
        <template #header>
          <span class="p-input-icon-left">
            <i class="pi pi-search" />
            <InputText
              v-model="filters1['global'].value"
              placeholder="Global Search"
            />
          </span>
        </template>
        <Column field="name" header="Name" :sortable="true" style="width: 25%">
          <template #filter>
            <InputText
              type="text"
              v-model="filters1['name']"
              class="p-column-filter"
              placeholder="Search by name"
            />
          </template>
        </Column>
        <Column
          header="Country"
          :sortable="true"
          sortField="country.name"
          filterField="country.name"
          filterMatchMode="contains"
          style="width: 25%"
        >
          <template #body="slotProps">
            <img
              src="https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png"
              width="20"
            />
            <span class="image-text">{{ slotProps.data.country.name }}</span>
          </template>
          <template #filter>
            <InputText
              type="text"
              v-model="filters1['country.name']"
              class="p-column-filter"
              placeholder="Search by country"
            />
          </template>
        </Column>
        <Column
          header="Representative"
          :sortable="true"
          sortField="representative.name"
          filterField="representative.name"
          filterMatchMode="in"
          style="width: 25%"
        >
          <template #body="slotProps">
            <img
              :alt="slotProps.data.representative.name"
              src="https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png"
              width="20"
              style="vertical-align: middle"
            />
            <span class="image-text">{{
              slotProps.data.representative.name
            }}</span>
          </template>
          <template #filter>
            <MultiSelect
              v-model="filters1['representative.name']"
              :options="representatives"
              optionLabel="name"
              optionValue="name"
              placeholder="All"
              class="p-column-filter"
            >
              <template #option="slotProps">
                <div class="p-multiselect-representative-option">
                  <img
                    :alt="slotProps.option.name"
                    src="https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png"
                    width="20"
                    style="vertical-align: middle"
                  />
                  <span class="image-text">{{ slotProps.option.name }}</span>
                </div>
              </template>
            </MultiSelect>
          </template>
        </Column>
        <Column
          field="status"
          header="Status"
          :sortable="true"
          filterMatchMode="equals"
          style="width: 25%"
        >
          <template #body="slotProps">
            <span :class="'customer-badge status-' + slotProps.data.status">{{
              slotProps.data.status
            }}</span>
          </template>
          <template #filter>
            <Dropdown
              v-model="filters1['status']"
              :options="statuses"
              placeholder="Select a Status"
              class="p-column-filter"
              :showClear="true"
            >
              <template #option="slotProps">
                <span :class="'customer-badge status-' + slotProps.option">{{
                  slotProps.option
                }}</span>
              </template>
            </Dropdown>
          </template>
        </Column>
        <template #empty> No customers found. </template>
      </DataTable>
    </div>
  </div>
</template>

<script>
import Column from "primevue/column";
// import { FilterMatchMode } from 'primevue/api';
import DataTable from "primevue/datatable";
import Dropdown from "primevue/dropdown";
import MultiSelect from "primevue/multiselect";
import InputText from "primevue/inputtext";
import { FilterMatchMode } from "primevue/api";
// import FilterMatchMode from "primevue/filtermatchmode";
// import { defineComponent } from "@vue/composition-api";

export default {
   name: "ChamadosComponent",
  components: {
    Column,
    DataTable,
    Dropdown,
    MultiSelect,
    InputText,
    FilterMatchMode
  },
  data() {
    return {
      customers: null,
      selectedCustomer1: null,
      selectedCustomer2: null,
      filters1: {},
      filters2: {},
      loading: true,
      representatives: [
        { name: "Amy Elsner", image: "amyelsner.png" },
        { name: "Anna Fali", image: "annafali.png" },
        { name: "Asiya Javayant", image: "asiyajavayant.png" },
        { name: "Bernardo Dominic", image: "bernardodominic.png" },
        { name: "Elwin Sharvill", image: "elwinsharvill.png" },
        { name: "Ioni Bowcher", image: "ionibowcher.png" },
        { name: "Ivan Magalhaes", image: "ivanmagalhaes.png" },
        { name: "Onyama Limba", image: "onyamalimba.png" },
        { name: "Stephen Shaw", image: "stephenshaw.png" },
        { name: "XuXue Feng", image: "xuxuefeng.png" },
      ],
      statuses: [
        "unqualified",
        "qualified",
        "new",
        "negotiation",
        "renewal",
        "proposal",
      ],
    };
  },
  mounted() {
    this.customerService
      .getCustomersMedium()
      .then((data) => (this.customers = data));
  },
  methods: {
    initFilters1() {
      this.filters1 = {
        global: { value: null, matchMode: FilterMatchMode.CONTAINS },
      };
    },
    initFilters2() {
      this.filters2 = {
        global: { value: null, matchMode: FilterMatchMode.CONTAINS },
      };
    },
  },
};
</script>